package com.stancforma.dxf;

import com.stancforma.dxf.dxfAssembler.DxfHeader;
import com.stancforma.dxf.hatch.DxfHatch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dxf {

    enum DxfItemEnum {
        UNDEFINED,
        TABLE,
        TABLE_ENTRY,
        ENTITY,
        BLOCK,
        OBJECT
    };


    private Map<Integer, DxfItem> handles;



    private List<DxfHeader> header;
    private List<Class> classes;
    private List<DxfTable> tables;
    private List<DxfBlock> blocks;
    private List<DxfEntity> entities;
    private List<Object> objects;

    Dxf() {
        handles = new HashMap<>();
        classes = new LinkedList<>();
        tables = new LinkedList<>();
        blocks = new LinkedList<>();
        entities = new LinkedList<>();
        objects = new LinkedList<>();
    }


    int generateHandle() {
        int h = handles.entrySet().iterator().next().getKey() + 1;
        if (h < 0x8000) {
            h = 0x8000;
        }
        return h;
    }


    public DxfBlock findBlock(String name) {

        DxfBlock res = null;

        for (DxfBlock block : blocks) {
            if (block.name().equals(name)) {
                return block;
            }
        }

        return res;
    }

    public List<DxfHatch> getHatchesForBlock(String blockName) {
        List<DxfHatch> results = new LinkedList<>();

        DxfBlock block = findBlock(blockName);

        if (block != null) {
            for (DxfEntity entity : block.entities) {
                if (Util.mapValue(entity._container.getAttributes(), 0).asString().equals("HATCH")) {
                    results.add(new DxfHatch(entity));
                }
            }
        }

        return results;
    }

    public DxfHatch createHatchInBlock(DxfBlock block, String layer) {
        DxfHatch hatch = new DxfHatch(generateHandle(), block.owner(), layer);

        block.entities.add(hatch.get_entity());

        handles.put(hatch.get_entity().handle(), (DxfItem) hatch.get_entity());

        return hatch;
    }

    List<DxfInsert> getInserts() {

        List<DxfInsert> inserts = new LinkedList<>();

        for (DxfEntity entity : entities) {
            if (entity.type().equals("INSERT")) {
                try {
                    inserts.add(new DxfInsert(entity));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return inserts;
    }

    List<DxfInsert> getInsertsWithHatchOnLayer() throws Exception {
        throw new Exception("Not implemented");
    }

    public Map<Integer, DxfItem> getHandles() {
        return handles;
    }

    public List<DxfHeader> getHeader() {
        return header;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public List<DxfTable> getTables() {
        return tables;
    }

    public List<DxfBlock> getBlocks() {
        return blocks;
    }

    public List<DxfEntity> getEntities() {
        return entities;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setHandles(Map<Integer, DxfItem> handles) {
        this.handles = handles;
    }

    public void setHeader(List<DxfHeader> header) {
        this.header = header;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public void setTables(List<DxfTable> tables) {
        this.tables = tables;
    }

    public void setBlocks(List<DxfBlock> blocks) {
        this.blocks = blocks;
    }

    public void setEntities(List<DxfEntity> entities) {
        this.entities = entities;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}
