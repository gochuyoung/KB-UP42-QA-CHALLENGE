package com.up42.apitests.factory


import com.up42.apitests.dto.Job
import com.up42.apitests.dto.Sharpening
import com.up42.apitests.dto.Sobloo

class JobFactory {

    static final String[] IDS = ["S2A_MSIL1C_20190820T110621_N0208_R137_T30STF_20190820T132731"]
    static final double[] BBOX = [-5.369294, 36.104358, -5.33309, 36.165145]
    static final int LIMIT = 1
    static final int ZOOM_LEVEL = 14
    static final String STRENGTH = "medium"

    static Job buildJob() {
        return new Job(
                sobloo: new Sobloo(
                        ids: IDS,
                        bbox: BBOX,
                        limit: LIMIT,
                        zoomLevel: ZOOM_LEVEL
                ),
                sharpening: new Sharpening(
                        strength: STRENGTH
                )
        )
    }
}
