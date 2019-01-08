package com.stancforma.dxfReader;

public class DL_Codes {
    public static final Double M_PI = 3.1415926535897932384626433832795;
    public static final Integer DL_DXF_MAXLINE = 1024;
    public static final Integer DL_DXF_MAXGROUPCODE = 1100;

    Double[][] dxfColors = new Double[][]{
            {0.0, 0.0, 0.0},                // unused
            {1.0, 0.0, 0.0},                // 1
            {1.0, 1.0, 0.0},
            {0.0, 1.0, 0.0},
            {0.0, 1.0, 1.0},
            {0.0, 0.0, 1.0},
            {1.0, 0.0, 1.0},
            {1.0, 1.0, 1.0},                // black or white
            {0.5, 0.5, 0.5},
            {0.75, 0.75, 0.75},
            {1.0, 0.0, 0.0},                // 10
            {1.0, 0.5, 0.5},
            {0.65, 0.0, 0.0},
            {0.65, 0.325, 0.325},
            {0.5, 0.0, 0.0},
            {0.5, 0.25, 0.25},
            {0.3, 0.0, 0.0},
            {0.3, 0.15, 0.15},
            {0.15, 0.0, 0.0},
            {0.15, 0.075, 0.075},
            {1.0, 0.25, 0.0},             // 20
            {1.0, 0.625, 0.5},
            {0.65, 0.1625, 0.0},
            {0.65, 0.4063, 0.325},
            {0.5, 0.125, 0.0},
            {0.5, 0.3125, 0.25},
            {0.3, 0.075, 0.0},
            {0.3, 0.1875, 0.15},
            {0.15, 0.0375, 0.0},
            {0.15, 0.0938, 0.075},
            {1.0, 0.5, 0.0},              // 30
            {1.0, 0.75, 0.5},
            {0.65, 0.325, 0.0},
            {0.65, 0.4875, 0.325},
            {0.5, 0.25, 0.0},
            {0.5, 0.375, 0.25},
            {0.3, 0.15, 0.0},
            {0.3, 0.225, 0.15},
            {0.15, 0.075, 0.0},
            {0.15, 0.1125, 0.075},
            {1.0, 0.75, 0.0},             // 40
            {1.0, 0.875, 0.5},
            {0.65, 0.4875, 0.0},
            {0.65, 0.5688, 0.325},
            {0.5, 0.375, 0.0},
            {0.5, 0.4375, 0.25},
            {0.3, 0.225, 0.0},
            {0.3, 0.2625, 0.15},
            {0.15, 0.1125, 0.0},
            {0.15, 0.1313, 0.075},
            {1.0, 1.0, 0.0},                // 50
            {1.0, 1.0, 0.5},
            {0.65, 0.65, 0.0},
            {0.65, 0.65, 0.325},
            {0.5, 0.5, 0.0},
            {0.5, 0.5, 0.25},
            {0.3, 0.3, 0.0},
            {0.3, 0.3, 0.15},
            {0.15, 0.15, 0.0},
            {0.15, 0.15, 0.075},
            {0.75, 1.0, 0.0},             // 60
            {0.875, 1.0, 0.5},
            {0.4875, 0.65, 0.0},
            {0.5688, 0.65, 0.325},
            {0.375, 0.5, 0.0},
            {0.4375, 0.5, 0.25},
            {0.225, 0.3, 0.0},
            {0.2625, 0.3, 0.15},
            {0.1125, 0.15, 0.0},
            {0.1313, 0.15, 0.075},
            {0.5, 1.0, 0.0},              // 70
            {0.75, 1.0, 0.5},
            {0.325, 0.65, 0.0},
            {0.4875, 0.65, 0.325},
            {0.25, 0.5, 0.0},
            {0.375, 0.5, 0.25},
            {0.15, 0.3, 0.0},
            {0.225, 0.3, 0.15},
            {0.075, 0.15, 0.0},
            {0.1125, 0.15, 0.075},
            {0.25, 1.0, 0.0},             // 80
            {0.625, 1.0, 0.5},
            {0.1625, 0.65, 0.0},
            {0.4063, 0.65, 0.325},
            {0.125, 0.5, 0.0},
            {0.3125, 0.5, 0.25},
            {0.075, 0.3, 0.0},
            {0.1875, 0.3, 0.15},
            {0.0375, 0.15, 0.0},
            {0.0938, 0.15, 0.075},
            {0.0, 1.0, 0.0},                // 90
            {0.5, 1.0, 0.5},
            {0.0, 0.65, 0.0},
            {0.325, 0.65, 0.325},
            {0.0, 0.5, 0.0},
            {0.25, 0.5, 0.25},
            {0.0, 0.3, 0.0},
            {0.15, 0.3, 0.15},
            {0.0, 0.15, 0.0},
            {0.075, 0.15, 0.075},
            {0.0, 1.0, 0.25},             // 100
            {0.5, 1.0, 0.625},
            {0.0, 0.65, 0.1625},
            {0.325, 0.65, 0.4063},
            {0.0, 0.5, 0.125},
            {0.25, 0.5, 0.3125},
            {0.0, 0.3, 0.075},
            {0.15, 0.3, 0.1875},
            {0.0, 0.15, 0.0375},
            {0.075, 0.15, 0.0938},
            {0.0, 1.0, 0.5},              // 110
            {0.5, 1.0, 0.75},
            {0.0, 0.65, 0.325},
            {0.325, 0.65, 0.4875},
            {0.0, 0.5, 0.25},
            {0.25, 0.5, 0.375},
            {0.0, 0.3, 0.15},
            {0.15, 0.3, 0.225},
            {0.0, 0.15, 0.075},
            {0.075, 0.15, 0.1125},
            {0.0, 1.0, 0.75},             // 120
            {0.5, 1.0, 0.875},
            {0.0, 0.65, 0.4875},
            {0.325, 0.65, 0.5688},
            {0.0, 0.5, 0.375},
            {0.25, 0.5, 0.4375},
            {0.0, 0.3, 0.225},
            {0.15, 0.3, 0.2625},
            {0.0, 0.15, 0.1125},
            {0.075, 0.15, 0.1313},
            {0.0, 1.0, 1.0},                // 130
            {0.5, 1.0, 1.0},
            {0.0, 0.65, 0.65},
            {0.325, 0.65, 0.65},
            {0.0, 0.5, 0.5},
            {0.25, 0.5, 0.5},
            {0.0, 0.3, 0.3},
            {0.15, 0.3, 0.3},
            {0.0, 0.15, 0.15},
            {0.075, 0.15, 0.15},
            {0.0, 0.75, 1.0},             // 140
            {0.5, 0.875, 1.0},
            {0.0, 0.4875, 0.65},
            {0.325, 0.5688, 0.65},
            {0.0, 0.375, 0.5},
            {0.25, 0.4375, 0.5},
            {0.0, 0.225, 0.3},
            {0.15, 0.2625, 0.3},
            {0.0, 0.1125, 0.15},
            {0.075, 0.1313, 0.15},
            {0.0, 0.5, 1.0},              // 150
            {0.5, 0.75, 1.0},
            {0.0, 0.325, 0.65},
            {0.325, 0.4875, 0.65},
            {0.0, 0.25, 0.5},
            {0.25, 0.375, 0.5},
            {0.0, 0.15, 0.3},
            {0.15, 0.225, 0.3},
            {0.0, 0.075, 0.15},
            {0.075, 0.1125, 0.15},
            {0.0, 0.25, 1.0},             // 160
            {0.5, 0.625, 1.0},
            {0.0, 0.1625, 0.65},
            {0.325, 0.4063, 0.65},
            {0.0, 0.125, 0.5},
            {0.25, 0.3125, 0.5},
            {0.0, 0.075, 0.3},
            {0.15, 0.1875, 0.3},
            {0.0, 0.0375, 0.15},
            {0.075, 0.0938, 0.15},
            {0.0, 0.0, 1.0},                // 170
            {0.5, 0.5, 1.0},
            {0.0, 0.0, 0.65},
            {0.325, 0.325, 0.65},
            {0.0, 0.0, 0.5},
            {0.25, 0.25, 0.5},
            {0.0, 0.0, 0.3},
            {0.15, 0.15, 0.3},
            {0.0, 0.0, 0.15},
            {0.075, 0.075, 0.15},
            {0.25, 0.0, 1.0},             // 180
            {0.625, 0.5, 1.0},
            {0.1625, 0.0, 0.65},
            {0.4063, 0.325, 0.65},
            {0.125, 0.0, 0.5},
            {0.3125, 0.25, 0.5},
            {0.075, 0.0, 0.3},
            {0.1875, 0.15, 0.3},
            {0.0375, 0.0, 0.15},
            {0.0938, 0.075, 0.15},
            {0.5, 0.0, 1.0},              // 190
            {0.75, 0.5, 1.0},
            {0.325, 0.0, 0.65},
            {0.4875, 0.325, 0.65},
            {0.25, 0.0, 0.5},
            {0.375, 0.25, 0.5},
            {0.15, 0.0, 0.3},
            {0.225, 0.15, 0.3},
            {0.075, 0.0, 0.15},
            {0.1125, 0.075, 0.15},
            {0.75, 0.0, 1.0},             // 200
            {0.875, 0.5, 1.0},
            {0.4875, 0.0, 0.65},
            {0.5688, 0.325, 0.65},
            {0.375, 0.0, 0.5},
            {0.4375, 0.25, 0.5},
            {0.225, 0.0, 0.3},
            {0.2625, 0.15, 0.3},
            {0.1125, 0.0, 0.15},
            {0.1313, 0.075, 0.15},
            {1.0, 0.0, 1.0},                // 210
            {1.0, 0.5, 1.0},
            {0.65, 0.0, 0.65},
            {0.65, 0.325, 0.65},
            {0.5, 0.0, 0.5},
            {0.5, 0.25, 0.5},
            {0.3, 0.0, 0.3},
            {0.3, 0.15, 0.3},
            {0.15, 0.0, 0.15},
            {0.15, 0.075, 0.15},
            {1.0, 0.0, 0.75},             // 220
            {1.0, 0.5, 0.875},
            {0.65, 0.0, 0.4875},
            {0.65, 0.325, 0.5688},
            {0.5, 0.0, 0.375},
            {0.5, 0.25, 0.4375},
            {0.3, 0.0, 0.225},
            {0.3, 0.15, 0.2625},
            {0.15, 0.0, 0.1125},
            {0.15, 0.075, 0.1313},
            {1.0, 0.0, 0.5},              // 230
            {1.0, 0.5, 0.75},
            {0.65, 0.0, 0.325},
            {0.65, 0.325, 0.4875},
            {0.5, 0.0, 0.25},
            {0.5, 0.25, 0.375},
            {0.3, 0.0, 0.15},
            {0.3, 0.15, 0.225},
            {0.15, 0.0, 0.075},
            {0.15, 0.075, 0.1125},
            {1.0, 0.0, 0.25},             // 240
            {1.0, 0.5, 0.625},
            {0.65, 0.0, 0.1625},
            {0.65, 0.325, 0.4063},
            {0.5, 0.0, 0.125},
            {0.5, 0.25, 0.3125},
            {0.3, 0.0, 0.075},
            {0.3, 0.15, 0.1875},
            {0.15, 0.0, 0.0375},
            {0.15, 0.075, 0.0938},
            {0.33, 0.33, 0.33},       // 250
            {0.464, 0.464, 0.464},
            {0.598, 0.598, 0.598},
            {0.732, 0.732, 0.732},
            {0.866, 0.866, 0.866},
            {1.0, 1.0, 1.0}                 // 255
    };

    // AutoCAD VERSION aliases
    public final static version DL_VERSION_R12 = version.AC1009;
    public final static version DL_VERSION_LT2 = version.AC1009;
    public final static version DL_VERSION_R13 = version.AC1012;   // not supported yet
    public final static version DL_VERSION_LT95 = version.AC1012;   // not supported yet
    public final static version DL_VERSION_R14 = version.AC1014;   // not supported yet
    public final static version DL_VERSION_LT97 = version.AC1014;   // not supported yet
    public final static version DL_VERSION_LT98 = version.AC1014;   // not supported yet
    public final static version DL_VERSION_2000 = version.AC1015;
    public final static version DL_VERSION_2002 = version.AC1015;


// DXF Group Codes:

    // Strings
    public final static Integer DL_STRGRP_START = 0;
    public final static Integer DL_STRGRP_END = 9;

    // Coordinates
    public final static Integer DL_CRDGRP_START = 10;
    public final static Integer DL_CRDGRP_END = 19;

    // Real values
    public final static Integer DL_RLGRP_START = 38;
    public final static Integer DL_RLGRP_END = 59;

    // Short integer values
    public final static Integer DL_SHOGRP_START = 60;
    public final static Integer DL_SHOGRP_END = 79;

    // New in Release 13,
    public final static Integer DL_SUBCLASS = 100;

    // More coordinates
    public final static Integer DL_CRD2GRP_START = 210;
    public final static Integer DL_CRD2GRP_END = 239;

    // Extended data strings
    public final static Integer DL_ESTRGRP_START = 1000;
    public final static Integer DL_ESTRGRP_END = 1009;

    // Extended data reals
    public final static Integer DL_ERLGRP_START = 1010;
    public final static Integer DL_ERLGRP_END = 1059;


    public final static Integer DL_Y8_COORD_CODE = 28;
    public final static Integer DL_Z0_COORD_CODE = 30;
    public final static Integer DL_Z8_COORD_CODE = 38;

    public final static Integer DL_POINT_COORD_CODE = 10;
    public final static Integer DL_INSERT_COORD_CODE = 10;

    public final static Integer DL_THICKNESS = 39;
    //public final static Integer DL_FIRST_REAL_CODE      THICKNESS
    public final static Integer DL_LAST_REAL_CODE = 59;
    public final static Integer DL_FIRST_INT_CODE = 60;
    public final static Integer DL_ATTFLAGS_CODE = 70;
    public final static Integer DL_PLINE_FLAGS_CODE = 70;
    public final static Integer DL_LAYER_FLAGS_CODE = 70;
    public final static Integer DL_FLD_LEN_CODE = 73; // Inside ATTRIB resbuf
    public final static Integer DL_LAST_INT_CODE = 79;
    public final static Integer DL_X_EXTRU_CODE = 210;
    public final static Integer DL_Y_EXTRU_CODE = 220;
    public final static Integer DL_Z_EXTRU_CODE = 230;
    public final static Integer DL_COMMENT_CODE = 999;

    // Start and endpoints of a line
    public final static Integer DL_LINE_START_CODE = 10;  // Followed by x coord
    public final static Integer DL_LINE_END_CODE = 11;  // Followed by x coord

    // Some codes used by blocks
    public final static Integer DL_BLOCK_FLAGS_CODE = 70;  // An int containing flags
    public final static Integer DL_BLOCK_BASE_CODE = 10;  // Origin of block definition
    public final static Integer DL_XREF_DEPENDENT = 16;  // If a block contains an XREF
    public final static Integer DL_XREF_RESOLVED = 32;  // If a XREF resolved ok
    public final static Integer DL_REFERENCED = 64;  // If a block is ref'd in DWG

    public final static Integer DL_XSCALE_CODE = 41;
    public final static Integer DL_YSCALE_CODE = 42;
    public final static Integer DL_ANGLE_CODE = 50;
    public final static Integer DL_INS_POINT_CODE = 10; // Followed by x of ins pnt
    public final static Integer DL_NAME2_CODE = 3;  // Second appearance of name

    // Some codes used by circle entities
    public final static Integer DL_CENTER_CODE = 10;  // Followed by x of center
    public final static Integer DL_RADIUS_CODE = 40;  // Followd by radius of circle

    public final static Integer DL_COND_OP_CODE = -4;  // Conditional op,ads_ssget

    // When using ads_buildlist you MUST use RTDXF0 instead of these
    public final static Integer DL_ENTITY_TYPE_CODE = 0;  // Then there is LINE, 3DFACE..
    public final static Integer DL_SES_CODE = 0;  // Start End String Code
    public final static Integer DL_FILE_SEP_CODE = 0;  // File separator
    public final static Integer DL_SOT_CODE = 0;  // Start Of Table
    public final static Integer DL_TEXTVAL_CODE = 1;
    public final static Integer DL_NAME_CODE = 2;
    public final static Integer DL_BLOCK_NAME_CODE = 2;
    public final static Integer DL_SECTION_NAME_CODE = 2;
    public final static Integer DL_ENT_HAND_CODE = 5;  // What follows is hexa string
    public final static Integer DL_TXT_STYLE_CODE = 7;  // Inside attributes
    public final static Integer DL_LAYER_NAME_CODE = 8;  // What follows is layer name
    public final static Integer DL_FIRST_XCOORD_CODE = 10;  // Group code x of 1st coord
    public final static Integer DL_FIRST_YCOORD_CODE = 20;  // Group code y of 1st coord
    public final static Integer DL_FIRST_ZCOORD_CODE = 30;  // Group code z of 1st coord
    public final static Integer DL_L_START_CODE = 10;
    public final static Integer DL_L_END_CODE = 11;
    public final static Integer DL_TXTHI_CODE = 40;
    public final static Integer DL_SCALE_X_CODE = 41;
    public final static Integer DL_SCALE_Y_CODE = 42;
    public final static Integer DL_SCALE_Z_CODE = 43;
    public final static Integer DL_BULGE_CODE = 42; // Used in PLINE verts for arcs
    public final static Integer DL_ROTATION_CODE = 50;
    public final static Integer DL_COLOUR_CODE = 62;  // What follows is a color int
    public final static Integer DL_LTYPE_CODE = 6;  // What follows is a linetype


    // Attribute flags
    public final static Integer DL_ATTS_FOLLOW_CODE = 66;
    public final static Integer DL_ATT_TAG_CODE = 2;
    public final static Integer DL_ATT_VAL_CODE = 1;
    public final static Integer DL_ATT_FLAGS_CODE = 70; // 4 1 bit flags as follows...
    public final static Integer DL_ATT_INVIS_FLAG = 1;
    public final static Integer DL_ATT_CONST_FLAG = 2;
    public final static Integer DL_ATT_VERIFY_FLAG = 4;// Prompt and verify
    public final static Integer DL_ATT_PRESET_FLAG = 8;// No prompt and no verify

    // PLINE defines
// Flags
    public final static Integer DL_OPEN_PLINE = 0x00;
    public final static Integer DL_CLOSED_PLINE = 0x01;
    public final static Integer DL_POLYLINE3D = 0x80;
    public final static Integer DL_PFACE_MESH = 0x40;
    public final static Integer DL_PGON_MESH = 0x10;
    // Vertices follow entity, required in POLYLINES
    public final static Integer DL_VERTS_FOLLOW_CODE = 66; // Value should always be 1
    public final static Integer DL_VERTEX_COORD_CODE = 10;


    // LAYER flags
    public final static Integer DL_FROZEN = 1;
    public final static Integer DL_FROZEN_BY_DEF = 2;
    public final static Integer DL_LOCKED = 4;
    public final static Integer DL_OBJECT_USED = 64;  // Object is ref'd in the dwg

    public final static Integer DL_BLOCK_EN_CODE = -2;   // Block entity definition
    public final static Integer DL_E_NAME = -1;  // Entity name

    // Extended data codes
    public final static Integer DL_EXTD_SENTINEL = (-3);
    public final static Integer DL_EXTD_STR = 1000;
    public final static Integer DL_EXTD_APP_NAME = 1001;
    public final static Integer DL_EXTD_CTL_STR = 1002;
    public final static Integer DL_EXTD_LYR_STR = 1003;
    public final static Integer DL_EXTD_CHUNK = 1004;
    public final static Integer DL_EXTD_HANDLE = 1005;
    public final static Integer DL_EXTD_POINT = 1010;
    public final static Integer DL_EXTD_POS = 1011;
    public final static Integer DL_EXTD_DISP = 1012;
    public final static Integer DL_EXTD_DIR = 1013;
    public final static Integer DL_EXTD_FLOAT = 1040;
    public final static Integer DL_EXTD_DIST = 1041;
    public final static Integer DL_EXTD_SCALE = 1042;
    public final static Integer DL_EXTD_INT16 = 1070;
    public final static Integer DL_EXTD_INT32 = 1071;

    // UCS codes for use in ads_trans
    public final static Integer DL_WCS_TRANS_CODE = 0;
    public final static Integer DL_UCS_TRANS_CODE = 1;
    public final static Integer DL_DCS_TRANS_CODE = 2;
    public final static Integer DL_PCS_TRANS_CODE = 3;


}
