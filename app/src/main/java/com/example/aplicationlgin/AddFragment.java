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

import com.example.aplicationlgin.DB.ContactsDBHelper;
import com.example.aplicationlgin.Model.Receta;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    private ContactsDBHelper dbHelper;
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

    public AddFragment(ContactsDBHelper dbHelper, SQLiteDatabase db){
        this.db = db;
        this.dbHelper=dbHelper;
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
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

                Toast.makeText(getContext(), "correct entry", Toast.LENGTH_LONG).show();

            }


        });



     return root;
    }





}