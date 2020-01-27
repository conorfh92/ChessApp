public abstract class Tile {

    int tileCoordinate;

   //Constructor
    Tile(int tileCoordinate){

        this.tileCoordinate=tileCoordinate;
    }

    //Abstract methods(dont need to be filled in parent class)
    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();



    public static final class EmptyTile extends Tile {

        //Subclass constructor
        EmptyTile(int tileCoordinate) {
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

    public static final class OccupiedTile extends Tile {

        Piece pieceOnTile;

        //Subclass constructor
        OccupiedTile(int tileCoordinate,  Piece pieceOnTile) {
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
