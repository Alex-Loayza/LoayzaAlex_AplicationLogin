package com.example.aplicationlgin;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplicationlgin.DB.RecetasDBHelper;
import com.example.aplicationlgin.Model.Receta;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    private RecetasDBHelper dbHelper;
    private SQLiteDatabase db;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddFragment() {
        // Required empty public constructor
    }

    public AddFragment(RecetasDBHelper dbHelper, SQLiteDatabase db){
        this.db = db;
        this.dbHelper=dbHelper;
    }


    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_add, container, false);
        EditText txtNom1 = root.findViewById(R.id.txtNom1);
        EditText txtProcedencia = root.findViewById(R.id.txtProcedencia);
        EditText txtCategoria = root.findViewById(R.id.txtCategoria);
        final Button btnGuardar= root.findViewById(R.id.btnGuardar);



        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //create here executes on main thread after presses button

                Receta receta1 = new Receta(txtNom1.getText().toString());
                dbHelper.insertContact(db, receta1);

                Receta receta2 = new Receta(txtProcedencia.getText().toString());
                dbHelper.insertContact(db, receta2);

                Receta receta3 = new Receta(txtCategoria.getText().toString());
                dbHelper.insertContact(db, receta3);

                //We check that it has been entered correctly in the database
                for(int i =0; i<2; i++) {
                    Toast.makeText(getContext(), "Correct entry", Toast.LENGTH_LONG).show();
                }
            }
        });
     return root;
    }

}