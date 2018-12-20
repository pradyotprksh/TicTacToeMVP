package com.example.a3embed.tictactoemvp.Presenter;

import com.example.a3embed.tictactoemvp.Model.TicTacToeModel;

public class TicTacToePresenter implements TicTacToeIPresenter {

    private TicTacToeModel model;

    @Override
    public void setupGame(int currentPlayer, int[][] initGameStatus) {
        model = new TicTacToeModel(currentPlayer, initGameStatus);
    }

    @Override
    public void onPlayerPlayed(int currentPlayer, int[][] currentGameStatus) {
        if (currentPlayer == 0) {
            model.setCurPlayer(1);
        } else {
            model.setCurPlayer(0);
        }
        model.setValueStored(currentGameStatus);
    }

    @Override
    public int getCurrentPlayer() {
        return model.getCurPlayer();
    }

    @Override
    public String getGameResult() {
        int value = model.getGameResult(model.getValueStored());
        if (value == 0) {
            return "Player O Won The Game";
        } else if (value == 1) {
            return "Player X Won The Game";
        } else if (value == 2) {
            return "It's A Draw. Click To Start Again";
        } else {
            return "Continue";
        }
    }

    @Override
    public String getPlayerText() {
        if (model.getCurPlayer() == 0) {
            return "O";
        } else {
            return "X";
        }
    }

}
