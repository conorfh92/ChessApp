package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    private static final int[] CANDIDATE_MOVE_COORDINATES={-17,-15,-10,-6,6,10,15,17 }; //Used for valid move calculation

    Knight(final int piecePosition,final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {

        int candidateDestinationCoordinate; //Used to hold possible coordinates after offset calculated
        final List <Move> legalMoves = new ArrayList<>(); //Store list of legal moves (can contain different types of move)

        for(final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES){ //Iterate through possible coordinates
            candidateDestinationCoordinate=this.piecePosition+currentCandidateOffset;

            if(BoardUtils.isValidTileCoordinate()){

                if(isFirstColumnExclusion(this.piecePosition, currentCandidateOffset){ //Checks if first column exclusion applies
                    continue;
                }

                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if(!candidateDestinationCoordinate.isTileOccupied()){
                    legalMoves.add(new Move());
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                    if(this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new Move());
                    }

                }
            }
        }
        return ImmutableList.copyOf(legalMoves); //Using Guava Library
    }

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -17) || (candidateOffset == -10) || (candidateOffset == 6)
                || (candidateOffset == 15);
    }

}
