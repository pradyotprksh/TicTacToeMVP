package com.example.a3embed.tictactoemvp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a3embed.tictactoemvp.Presenter.TicTacToeIPresenter;
import com.example.a3embed.tictactoemvp.Presenter.TicTacToePresenter;
import com.example.a3embed.tictactoemvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.one1B) Button one1b;                                 // Button
    @BindView(R.id.one2B) Button one2b;                                 // Button
    @BindView(R.id.one3B) Button one3b;                                 // Button

    @BindView(R.id.two1B) Button two1b;                                 // Button
    @BindView(R.id.two2B) Button two2b;                                 // Button
    @BindView(R.id.two3B) Button two3b;                                 // Button

    @BindView(R.id.three1B) Button three1B;                             // Button
    @BindView(R.id.three2B) Button three2B;                             // Button
    @BindView(R.id.three3B) Button three3B;                             // Button

    @BindView(R.id.resetB) Button resetB;                               // Reset Button

    private TicTacToeIPresenter presenter;                              // Presenter Variable

    private int valueStored[][];                                        // Value Array[][]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
        presenter = new TicTacToePresenter();
        setUpBoard();
    }

    /**
     * <h>setUpBoard()</h>
     * <p>Setup board.</p>
     * */
    private void setUpBoard() {
        valueStored = new int[3][3];
        resetData();
        presenter.setupGame(0 , valueStored);
    }

    @Override
    public void onClick(View v) {
        int curPlayer = presenter.getCurrentPlayer();                   // Get current player
        switch (v.getId()) {
            case R.id.one1B :
                one1b.setText(presenter.getPlayerText());
                valueStored[0][0] = curPlayer;
                one1b.setEnabled(false);
                break;
            case R.id.one2B :
                one2b.setText(presenter.getPlayerText());
                valueStored[0][1] = curPlayer;
                one2b.setEnabled(false);
                break;
            case R.id.one3B :
                one3b.setText(presenter.getPlayerText());
                valueStored[0][2] = curPlayer;
                one3b.setEnabled(false);
                break;
            case R.id.two1B :
                two1b.setText(presenter.getPlayerText());
                valueStored[1][0] = curPlayer;
                two1b.setEnabled(false);
                break;
            case R.id.two2B :
                two2b.setText(presenter.getPlayerText());
                valueStored[1][1] = curPlayer;
                two2b.setEnabled(false);
                break;
            case R.id.two3B :
                two3b.setText(presenter.getPlayerText());
                valueStored[1][2] = curPlayer;
                two3b.setEnabled(false);
                break;
            case R.id.three1B :
                three1B.setText(presenter.getPlayerText());
                valueStored[2][0] = curPlayer;
                three1B.setEnabled(false);
                break;
            case R.id.three2B :
                three2B.setText(presenter.getPlayerText());
                valueStored[2][1] = curPlayer;
                three2B.setEnabled(false);
                break;
            case R.id.three3B :
                three3B.setText(presenter.getPlayerText());
                valueStored[2][2] = curPlayer;
                three3B.setEnabled(false);
                break;
            case R.id.resetB:
                resetData();
                curPlayer = 1;
                break;
        }
        presenter.onPlayerPlayed(curPlayer, valueStored);
        calculateGameStatus();
    }

    /**
     * <h>resetData()</h>
     * <p>Reset data when reset button is clicked.</p>
     * */
    private void resetData() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                valueStored[i][j] = 2;
            }
        }
        resetText();
        setEnable(true);
    }

    /**
     * <h>setEnable()</h>
     * <p>Enable/Disable the button depending on the
     * values received.</p>
     * */
    private void setEnable(boolean value) {
        one1b.setEnabled(value);
        one2b.setEnabled(value);
        one3b.setEnabled(value);
        two1b.setEnabled(value);
        two2b.setEnabled(value);
        two3b.setEnabled(value);
        three1B.setEnabled(value);
        three2B.setEnabled(value);
        three3B.setEnabled(value);
    }

    /**
     * <h>resetText()</h>
     * <p>Reset text of the buttons when reset button is clicked.</p>
     * */
    private void resetText() {
        one1b.setText("");
        one2b.setText("");
        one3b.setText("");
        two1b.setText("");
        two2b.setText("");
        two3b.setText("");
        three1B.setText("");
        three2B.setText("");
        three3B.setText("");
        resetB.setText(getString(R.string.reset_button));
    }

    /**
     * <h>calculateGameStatus()</h>
     * <p>Analyze the winner/draw or the game should continue.</p>
     * */
    private void calculateGameStatus() {
        String result = presenter.getGameResult();
        if (!result.equals("Continue")) {
            resetB.setText(result);
            setEnable(false);
        }
    }

}
