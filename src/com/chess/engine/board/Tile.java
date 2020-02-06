package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

//Abstract class cannot be instantiated but its child classes can.
//Immutability enforced here by protected/private and final keywords on mutable variables.
public abstract class Tile {

    protected final int tileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();//Creates hashmap of board

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles(){ //Method to generate hashmap

        final Map<Integer,EmptyTile> emptyTileMap= new HashMap<>(); //HashMap declaration with integer key and tile value

        for(int i=0;i<64;i++){
            emptyTileMap.put(i, new EmptyTile(i)); //Loops to fill HashMap with empty tiles and keys 0 to 63
        }

        return ImmutableMap.copyOf(emptyTileMap);//ImmutableMap part of external Guava library
    }
    //Only method which allows creation of tiles. Accesses constructor to create occupied tile if piece
    // is null. Otherwise returns the existing empty tile.
    public static Tile createTile(final int tileCoordinate, Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate,piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

   //Constructor (set to private for immutability)
    private Tile(int tileCoordinate){

        this.tileCoordinate=tileCoordinate;
    }


    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();


    //Sub-class EmptyTile
    public static final class EmptyTile extends Tile {

        //Subclass constructor
        private EmptyTile(final int tileCoordinate) {
            super(tileCoordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }
    //Sub-class OccupiedTile
    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile;

        //Subclass constructor
        private OccupiedTile(int tileCoordinate,  Piece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }

    }
}
