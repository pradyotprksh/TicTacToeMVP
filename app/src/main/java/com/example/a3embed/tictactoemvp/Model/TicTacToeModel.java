package com.example.a3embed.tictactoemvp.Model;

public class TicTacToeModel {

    private int curPlayer;
    private int valueStored[][];

    public TicTacToeModel(int curPlayer, int[][] valueStored) {
        this.curPlayer = curPlayer;
        this.valueStored = valueStored;
    }

    public int getCurPlayer() {
        return curPlayer;
    }

    public void setCurPlayer(int curPlayer) {
        this.curPlayer = curPlayer;
    }

    public int[][] getValueStored() {
        return valueStored;
    }

    public void setValueStored(int[][] valueStored) {
        this.valueStored = valueStored;
    }

    public int getGameResult(int[][] gameStatus) {
        if ((gameStatus[0][0] == 0 && gameStatus[1][1] == 0 && gameStatus[2][2] == 0)
                || (gameStatus[0][2] == 0 && gameStatus[1][1] == 0 && gameStatus[2][0] == 0)
                || (gameStatus[0][1] == 0 && gameStatus[1][1] == 0 && gameStatus[2][1] == 0)
                || (gameStatus[0][2] == 0 && gameStatus[1][2] == 0 && gameStatus[2][2] == 0)
                || (gameStatus[0][0] == 0 && gameStatus[0][1] == 0 && gameStatus[0][2] == 0)
                || (gameStatus[1][0] == 0 && gameStatus[1][1] == 0 && gameStatus[1][2] == 0)
                || (gameStatus[2][0] == 0 && gameStatus[2][1] == 0 && gameStatus[2][2] == 0)
                || (gameStatus[0][0] == 0 && gameStatus[1][0] == 0 && gameStatus[2][0] == 0)) {
            return 0;
        } else if ((gameStatus[0][0] == 1 && gameStatus[1][1] == 1 && gameStatus[2][2] == 1)
                || (gameStatus[0][2] == 1 && gameStatus[1][1] == 1 && gameStatus[2][0] == 1)
                || (gameStatus[0][1] == 1 && gameStatus[1][1] == 1 && gameStatus[2][1] == 1)
                || (gameStatus[0][2] == 1 && gameStatus[1][2] == 1 && gameStatus[2][2] == 1)
                || (gameStatus[0][0] == 1 && gameStatus[0][1] == 1 && gameStatus[0][2] == 1)
                || (gameStatus[1][0] == 1 && gameStatus[1][1] == 1 && gameStatus[1][2] == 1)
                || (gameStatus[2][0] == 1 && gameStatus[2][1] == 1 && gameStatus[2][2] == 1)
                || (gameStatus[0][0] == 1 && gameStatus[1][0] == 1 && gameStatus[2][0] == 1)) {
            return 1;
        } else {
            boolean empty = false;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(gameStatus[i][j] == 2) {
                        empty = true;
                        break;
                    }
                }
            }
            if(!empty) {
                return 2;
            } else {
                return 3;
            }
        }
    }

}
