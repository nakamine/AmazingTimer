package makeApp.amazingtimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
//MainActivityクラスの直下は、変数の宣言エリアです。
	EditText nanPun;								//EditText型の変数 "nanPun" を宣言(EditTextは画面から文字を入力するエリア)
	String nFunDayo;								//String(文字列)型の変数 "nFunDayo" を宣言
	int nFun =0;									//int(整数)型の変数 "nFun" を宣言
	Long byou;										//Long(数値)型の変数 "byou" を宣言
    MyCountDownTimer taimaa;				//MyCountDownTimer型の変数 "taimaa" を宣言


	@Override
	protected void onCreate(Bundle savedInstanceState) {		//アプリ起動時の動作を定義
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);						// activity_mainレイアウトを画面に表示

		nanPun = (EditText) findViewById(R.id.editText1);			// EditText型の変数 "nanPun" をレイアウト上のeditText1に紐付け
 	}

    public void onClickStart(View v) {						//[Start]ボタンタップ時の動作を定義
    	nFunDayo = nanPun.getText().toString();			//nanPunに入力された内容を文字列として取得し、nFunDayoに格納

    	nFun = Integer.parseInt(nFunDayo);				//nFunDayo (String) を整数に変換してnFun (int) に格納
    	taimaa = new MyCountDownTimer(nFun * 1000, 1000);	        //デバッグ用。本来は "分" を "秒" に解釈（" * 60" が無い）
      //taimaa = new MyCountDownTimer(nFun * 60 * 1000, 1000);	//実行用

    	taimaa.start();        										// カウントダウン開始
    }

    public void onClickCancel(View v) {		     			//[Cansel]ボタンタップ時の動作を定義
    	taimaa.cancel();											// カウントダウン中止
    }

    public class MyCountDownTimer extends CountDownTimer{			// "MyCountDownTime" メソッド の動作を定義:開始

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
         }

        @Override
        public void onFinish() {	           							 // カウントダウン完了後の処理を定義
            nanPun.setText(nFunDayo);							 // 設定した時間を改めて表示する
            Toast.makeText(getApplicationContext(), "時間です♪", Toast.LENGTH_LONG).show();	//ポップアップ画面にメッセージ表示
        }

        @Override
        public void onTick(long millisUntilFinished) {            // インターバル(countDownInterval)毎に実行される処理を定義
               byou = millisUntilFinished/1000;
               nanPun.setText(Long.toString(byou/60) + ":" + Long.toString(byou%60));
        }
    }																						// "MyCountDownTime" メソッド の動作を定義:終了
}

