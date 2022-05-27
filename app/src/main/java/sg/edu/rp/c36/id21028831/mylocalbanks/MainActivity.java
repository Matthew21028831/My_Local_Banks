package sg.edu.rp.c36.id21028831.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView btnUOB;
    TextView btnOCBC;
    TextView btnDBS;
    TextView bankingNeeds;
    TextView bankBelowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUOB=findViewById(R.id.btnUOB);
        btnDBS=findViewById(R.id.btnDBS);
        btnOCBC=findViewById(R.id.btnOCBC);
        bankingNeeds=findViewById(R.id.bankingNeeds);
        bankBelowText=findViewById(R.id.bankBelowText);

        registerForContextMenu(btnUOB);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnDBS);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    String wordClicked="";
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v==btnUOB){
            wordClicked="UOB";
        }else if(v==btnOCBC){
            wordClicked="OCBC";
        }else if(v==btnDBS){
            wordClicked="DBS";
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            btnDBS.setText("DBS");
            bankingNeeds.setText("Banking Needs");
            bankBelowText.setText("View your bank accounts here");
            return true;
        } else if (id == R.id.italianSelection) {
            btnUOB.setText("大华银行");
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            bankingNeeds.setText("银行需求");
            bankBelowText.setText("在此处查看您的银行帐户");
            return true;
        } else {
            btnOCBC.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("UOB")){
            if(item.getItemId()==0){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://pib.uob.com.sg/PIBLogin/Public/processPreCapture.do?keyId=lpc"));
                startActivity(browserIntent);

            }else if(item.getItemId()==1){
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1800222212));
                startActivity(intentcall);
            }
            return true;
            }else if (wordClicked.equalsIgnoreCase("OCBC")){

            if(item.getItemId()==0){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(browserIntent);

            }else if(item.getItemId()==1){
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1800363333));
                startActivity(intentcall);
            }
            return true;

        }else if (wordClicked.equalsIgnoreCase("DBS")){

            if(item.getItemId()==0){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(browserIntent);

            }else if(item.getItemId()==1){
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1800111111));
                startActivity(intentcall);
            }
            return true;

        }


        return super.onContextItemSelected(item);
    }
}