package com.chess.engine.board;

public class BoardUtils {

    public static final boolean FIRST_COLUMN = null;

    private BoardUtils(){
        throw new RuntimeException("BoardUtils cannot be instantiated");
    }







    public static boolean isValidTileCoordinate(int coordinate) {
        return coordinate >=0 && coordinate <63; //Check in bounds of board
    }
}
