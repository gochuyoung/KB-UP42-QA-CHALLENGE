package com.up42.apitests.factory

import com.up42.apitests.dto.Block

class BlockFactory {

    static final String SENTINEL_BLOCK_NAME = "sobloo-s2-l1c-aoiclipped"
    static final String SENTINEL_BLOCK_ID = "3a381e6b-acb7-4cec-ae65-50798ce80e64"
    static final String SHARPENING_FILTER_BLOCK_NAME =  "sharpening"
    static final String SHARPENING_FILTER_BLOCK_ID = "e374ea64-dc3b-4500-bb4b-974260fb203e"

    static Block buildSentinelBlock() {
        return new Block(
                name: SENTINEL_BLOCK_NAME,
                parentName: null,
                blockId: SENTINEL_BLOCK_ID
        )
    }

    static Block buildSharpeningFilterBlock() {
        return new Block(
                name: SHARPENING_FILTER_BLOCK_NAME,
                parentName: SENTINEL_BLOCK_NAME,
                blockId: SHARPENING_FILTER_BLOCK_ID
        )
    }
}
