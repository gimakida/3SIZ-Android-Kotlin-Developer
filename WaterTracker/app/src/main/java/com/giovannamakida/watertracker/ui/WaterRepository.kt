package com.giovannamakida.watertracker.ui

import kotlinx.coroutines.flow.Flow

interface WaterRepository{
    fun getCupsDrunk(): Flow<Int>
    suspend fun saveCupsDrunk(value: Int)
    suspend fun clear()
}