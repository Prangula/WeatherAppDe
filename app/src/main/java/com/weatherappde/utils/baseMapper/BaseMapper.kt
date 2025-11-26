package com.weatherappde.utils.baseMapper

interface BaseMapper<in MODEL_A, out MODEL_B> {
    fun mapModel(model: MODEL_A): MODEL_B {
        throw NotImplementedError()
    }
    fun mapModelGrouped(model: MODEL_A): Map<Int, List<MODEL_B>>{
        throw NotImplementedError()
    }
}