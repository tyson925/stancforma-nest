package com.stancforma.dxf.hatch;

import com.stancforma.dxf.DxfEntity;
import com.stancforma.dxf.DxfValue;
import com.stancforma.dxf.EnclosingRectangle;
import com.stancforma.dxf.Entity;

import java.util.LinkedList;
import java.util.List;

public class DxfHatch {

    public DxfEntity get_entity() {
        return _entity;
    }

    public DxfValue getNumOfLoops() {
        return numOfLoops;
    }

    public List<Loop> get_loops() {
        return _loops;
    }

    // Hatch
    DxfEntity _entity;
    DxfValue numOfLoops;
    List<Loop> _loops;
    //List<DxfValue*>::iterator loopsEnd;



    void eraseLoop() {
        _entity.get_container().setAttributes(new LinkedList<>());
        //TODO find
        //_loops.erase(it.base());
        numOfLoops.set((int) _loops.size());
    }

    Loop createStandardLoop() {
        Loop loop = Loop.standard (_entity.get_container().getAttributes());
        _loops.add(loop);
        numOfLoops.set((int) _loops.size());
        return loop;
    }

    Loop createPolylineLoop(boolean isClosed, boolean hasBulge) {
        Loop l = Loop.polyline (_entity.get_container().getAttributes(), isClosed, hasBulge);
        _loops.add(l);
        numOfLoops.set((int) _loops.size());
        return l;
    }

    public DxfHatch(DxfEntity entity) {
        this._entity = entity;
        parseValues();
    }

    public DxfHatch(int handle, int owner, String layer) {
        Entity e = new Entity();

        e.getAttributes().add(new DxfValue(0, "HATCH"));
        e.getAttributes().add(new DxfValue(5, handle));
        e.getAttributes().add(new DxfValue(330, owner));
        e.getAttributes().add(new DxfValue(100, "AcDbEntity"));
        e.getAttributes().add(new DxfValue(8, layer));
        e.getAttributes().add(new DxfValue(62, 252));
        e.getAttributes().add(new DxfValue(100, "AcDbHatch"));
        e.getAttributes().add(new DxfValue(10, 0.0));
        e.getAttributes().add(new DxfValue(20, 0.0));
        e.getAttributes().add(new DxfValue(30, 0.0));
        e.getAttributes().add(new DxfValue(210, 0.0));
        e.getAttributes().add(new DxfValue(220, 0.0));
        e.getAttributes().add(new DxfValue(230, 1.0));
        e.getAttributes().add(new DxfValue(2, "SOLID"));
        e.getAttributes().add(new DxfValue(70, 1));
        e.getAttributes().add(new DxfValue(71, 0));
        e.getAttributes().add(new DxfValue(91, 0));
        // loops will be inserted here
        e.getAttributes().add(new DxfValue(75, 0));
        e.getAttributes().add(new DxfValue(76, 1));
        e.getAttributes().add(new DxfValue(98, 1));
        e.getAttributes().add(new DxfValue(10, 0.0));
        e.getAttributes().add(new DxfValue(20, 0.0));

        _entity = new DxfEntity(e);

        parseValues();
    }

    private void parseValues() {
        List<DxfValue> list = _entity.get_container().getAttributes();


        int i= 0;
        for (;i< list.size();i++) {
            if (list.get(i).getGroupcode() == 91){
                break;
            }
        }
        numOfLoops = list.get(i);
        int loops = numOfLoops.asInt();
        ++i;

        for (int loop = 0; loop < loops; loop++) {
            // Decode loop data
            try {
                _loops.add(new Loop(list, i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public EnclosingRectangle getEnclosingRectangle() {
        // xmin, ymin, width, height
        EnclosingRectangle rect = new EnclosingRectangle();

        for (Loop loop : _loops) {
            rect.enclose(loop.getEnclosingRectangle());
        }

        // min-max to min-length
        return rect;
    }

}
