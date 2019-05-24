package sg.edu.rp.soi.p06_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etInt1, etInt2;
    TextView tvOp, tvRes;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInt1 = findViewById(R.id.etNum1);
        etInt2 = findViewById(R.id.etNum2);
        tvOp = findViewById(R.id.tvOperation);
        tvRes = findViewById(R.id.tvResult);
        reset = findViewById(R.id.btnReset);

        registerForContextMenu(tvOp);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etInt1.setText("");
                etInt2.setText("");

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"+");
        menu.add(0,1,1,"-");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String et1 = etInt1.getText().toString();
        String et2 = etInt2.getText().toString();

        int int1 = Integer.parseInt(et1);
        int int2 = Integer.parseInt(et2);

            if (item.getItemId() == 0) {

                int result = (int1 + int2);
                tvRes.setText("The addition of " + int1 + " and " + int2 + " is " + result);
                return true;

            } else if (item.getItemId() == 1) {

                int result = (int1 - int2);
                tvRes.setText("The subtraction of " + int1 + " and " + int2 + " is " + result);

                return true;

            } else {

                tvRes.setText("Please set integer for calculation");

            }

        return super.onContextItemSelected(item);

    }

}
