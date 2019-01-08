package com.stancforma.dxfReader.entities;

public class DL_LeaderData {

    /*! Arrow head flag (71). */
    int arrowHeadFlag;
    /*! Leader path type (72). */
    int leaderPathType;
    /*! Leader creation flag (73). */
    int leaderCreationFlag;
    /*! Hookline direction flag (74). */
    int hooklineDirectionFlag;
    /*! Hookline flag (75) */
    int hooklineFlag;
    /*! Text annotation height (40). */
    double textAnnotationHeight;
    /*! Text annotation width (41) */
    double textAnnotationWidth;
    /*! Number of vertices in leader (76). */
    int number;

    public DL_LeaderData(int arrowHeadFlag, int leaderPathType, int leaderCreationFlag, int hooklineDirectionFlag, int hooklineFlag, double textAnnotationHeight, double textAnnotationWidth, int number) {
        this.arrowHeadFlag = arrowHeadFlag;
        this.leaderPathType = leaderPathType;
        this.leaderCreationFlag = leaderCreationFlag;
        this.hooklineDirectionFlag = hooklineDirectionFlag;
        this.hooklineFlag = hooklineFlag;
        this.textAnnotationHeight = textAnnotationHeight;
        this.textAnnotationWidth = textAnnotationWidth;
        this.number = number;
    }
}
