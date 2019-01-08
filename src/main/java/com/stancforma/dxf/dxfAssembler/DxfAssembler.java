package com.stancforma.dxf.dxfAssembler;

import com.stancforma.dxf.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.stancforma.dxf.dxfAssembler.DxfAssembler.Section.*;

public class DxfAssembler {

    enum Section {
        UNDEFINED,
        HEADER,
        CLASSES,
        TABLES,
        BLOCKS,
        ENTITIES,
        OBJECTS
    }

    ;

    Map<String, Section> str2section;

    void initializeStringToSection() {
        str2section = new HashMap<>();
        str2section.put("UNDEFINED", UNDEFINED);
        str2section.put("HEADER", HEADER);
        str2section.put("CLASSES", CLASSES);
        str2section.put("TABLES", TABLES);
        str2section.put("BLOCKS", BLOCKS);
        str2section.put("ENTITIES", ENTITIES);
        str2section.put("OBJECTS", OBJECTS);
    }

    private Section section;
    private List<SectionContent> sectionContent;

    private Table tableContent;
    private TableEntry tableEntryContent;

    private Class classContent;

    private Block blockContent;

    private Entity entityContent;

    private Object objectContent;

    private Dxf dxf;


    DxfAssembler() {
        section = UNDEFINED;
        tableContent = null;
        tableEntryContent = null;
        classContent = null;
        blockContent = null;
        entityContent = null;
        objectContent = null;

        initializeStringToSection();
    }

    // Convert strings to DxfValues
    List<DxfValue> toValueList(List<SectionContent> contents) {
        List<DxfValue> data = new LinkedList<>();

        for (SectionContent sectionContent : contents) {
            data.add(new DxfValue(sectionContent.getSectionContentKey(), sectionContent.getSectionContentValue()));
        }

        return data;
    }

    /* STRUCTURE BUILDING FUNCTIONS */

    void processCodeValuePair(int code, String value) {
        sectionContent.add(new SectionContent(code, value));
    }

    Boolean find(List<SectionContent> sectionContents, String searchValue){

        for (SectionContent sectionContent : sectionContents){
            if (sectionContent.getSectionContentValue().equals(searchValue)){
                return true;
            }
        }

        return false;
    }

    void handleTables() {
        if (find(sectionContent,"TABLE")){
            tableContent = new Table();
            tableContent.setAttributes(toValueList(sectionContent));

        } else if (find (sectionContent, Util.mapValue(tableContent.getAttributes(), 2).asString())){
            tableEntryContent = new TableEntry();
            tableEntryContent.setAttributes(toValueList(sectionContent));
            tableContent.getRecords().add(tableEntryContent);
            tableEntryContent = null;

        } else if (find (sectionContent, "ENDTAB")){

            DxfTable table = new DxfTable(tableContent);

            dxf.getHandles().put(table.handle(),table);
            dxf.getTables().add(table);

            for (DxfTableEntry tableEntry : table.getEntries()) {
                dxf.getHandles().put(tableEntry.handle(), tableEntry);
            }

            tableContent = null;
        }
    }


    // CALLBACKS FROM DXF LIB
    // Useful to store header name-value pairs especially for vectors

    void setVariableVector(String name, double x, double y, double z, int groupcode) {
        switch (section) {
            case HEADER:
                dxf.getHeader().add(new DxfHeader(name, new DxfValue(groupcode, x, y, z)));
                break;
        }
    }

    void setVariableString(String name, String value, int groupcode) {
        switch (section) {
            case HEADER:
                dxf.getHeader().add(new DxfHeader(name, new DxfValue(groupcode, value)));
                break;
        }
    }

    void setVariableInt(String name, int value, int groupcode) {
        switch (section) {
            case HEADER:
                dxf.getHeader().add(new DxfHeader(name, new DxfValue(groupcode, value)));
                break;
        }
    }

    void setVariableDouble(String name, double value, int groupcode) {
        switch (section) {
            case HEADER:
                dxf.getHeader().add(new DxfHeader(name, new DxfValue(groupcode, value)));
                break;
        }
    }

}
