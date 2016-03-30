package stargazer.server.domain;

import org.json.JSONObject;

/**
 * High level accessor of a block. Contains both the parsed and raw JSON object
 * returned from the API.
 *
 * @author restrada
 *
 */
public class BlockJsonType {

    private final BlockType blockType;
    private final JSONObject blockJson;

    public BlockJsonType(BlockType blockType, JSONObject blockJson) {
        this.blockType = blockType;
        this.blockJson = blockJson;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public JSONObject getBlockJson() {
        return blockJson;
    }
}
