package com.up42.apitests.dto

import com.google.gson.annotations.SerializedName

class Job {

    @SerializedName("sobloo-s2-l1c-aoiclipped")
    Sobloo sobloo

    Sharpening sharpening
}

class Sobloo {

    String[] ids
    double[] bbox
    int limit

    @SerializedName("zoom_level")
    int zoomLevel
}

class Sharpening {

    String strength
}
