package com.example.a3embed.tictactoemvp.Presenter;

public interface TicTacToeIPresenter {

    /**
     * <h>setupGame()</h>
     * <p>Setup game.</p>
     * */
    void setupGame(int currentPlayer, int[][] initGameStatus);

    /**
     * <h>onPlayerPlayed()</h>
     * <p>When player plays this method is invoked.</p>
     * */
    void onPlayerPlayed(int currentPlayer, int[][] currentGameStatus);

    /**
     * <h>getCurrentPlayer()</h>
     * <p>Get the current player which is playing.</p>
     * */
    int getCurrentPlayer();

    /**
     * <h>getGameResult()</h>
     * <p>Get the game result after every play.</p>
     * */
    String getGameResult();

    /**
     * <h>getPlayerText()</h>
     * <p>Get the text to be set on the button when player is played.</p>
     * */
    String getPlayerText();

}
