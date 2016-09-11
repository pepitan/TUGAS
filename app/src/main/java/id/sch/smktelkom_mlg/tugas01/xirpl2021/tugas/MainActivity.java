package id.sch.smktelkom_mlg.tugas01.xirpl2021.tugas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText etNama;
    EditText etTahun;
    Button bOK;
    TextView tvHasil;
    TextView tvL;
    RadioGroup rgStatus;
    RadioButton rl, rp;
    CheckBox cb1,cb2;
    int nLulus;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = (Spinner) findViewById(R.id.spinner);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });


        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvL = (TextView) findViewById(R.id.textViewL);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });

        rgStatus = (RadioGroup) findViewById(R.id.radioGroup1);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rl = (RadioButton) findViewById(R.id.radioButton2);
        rp = (RadioButton) findViewById(R.id.radioButton);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });

        rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                if(i == R.id.radioGroup1)
                {
                    findViewById(R.id.radioGroup1).setVisibility(View.GONE);
                }

                else
                {
                    findViewById(R.id.radioGroup1).setVisibility(View.VISIBLE);
                }
            }
        });

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);

        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                doProcess();

            }
        });
    }

    private void doProcess()
    {
        String hasil3 = sp.getContext().toString();

        if(hasil3 == "")
        {
            tvHasil.setText("Anda belum memilih jurusan");
        }

        String nama1 = etNama.getText().toString();
        String hasil1 = "\nHal yang diinginkan "  + nama1 +  " setelah lulus : ";
        int startlen = hasil1.length();

        if(cb1.isChecked()) hasil1+=cb1.getText()+"\n";
        if(cb2.isChecked()) hasil1+=cb2.getText()+"\n";

        if(hasil1.length() == startlen) hasil1+="Tidak ada pilihan \n";
        tvHasil.setText(hasil1);


        String hasil = null;

        if(hasil == null)
        {
            tvHasil.setText("Belum diisi");
        }

        if(rl.isChecked())
        {
            hasil = rl.getText().toString();
        }

        else if(rp.isChecked())
        {
            hasil = rp.getText().toString();
        }

        if(isValid())
        {
            String nama = etNama.getText().toString();
            int Tahun = Integer.parseInt(etTahun.getText().toString());
            tvHasil.setText("Nama Anda : " + nama + "\nLahir Tahun : " + Tahun + "\nJenis Kelamin :" + hasil +"\nJurusan yang diinginkan :" + sp.getSelectedItem().toString()
                    + hasil1);
        }

    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText() .toString();
        String umur = etTahun.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid  = false;
        }

        else
        {
            etNama.setError(null);
        }


        if(umur.isEmpty())
        {
            etTahun.setError("Tahun Belum Diiisi");
            valid = false;
        }

        else
        {
            etTahun.setError(null);
        }

        return valid;
    }}

