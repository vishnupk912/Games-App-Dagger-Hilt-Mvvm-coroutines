package com.vishnu.dagger.base

import com.google.gson.annotations.SerializedName

data  class BaseResponse(
    @SerializedName("error")
    val  error:String
)