package com.example.feedbackapp.ui.assignment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.feedbackapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddAssignmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddAssignmentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AssignmentViewModel assignmentViewModel;

    // TODO: Control Varible
    Spinner spinner_module, spinner_class, spinner_trainer;
    Button btn_Save, btn_Back;
    TextView textView2;

    public AddAssignmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddAssignmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddAssignmentFragment newInstance(String param1, String param2) {
        AddAssignmentFragment fragment = new AddAssignmentFragment();
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

        assignmentViewModel =
                new ViewModelProvider(this).get(AssignmentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add_assignment, container, false);

        addEvents(root);
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();

        if(bundle != null){
            // handle your code here.
            bundle.getBundle("key");
            btn_Save.setText("abc");
        }
        return inflater.inflate(R.layout.fragment_add_assignment, container, false);
    }

    private void addEvents(View root) {
        addControls(root);
        textView2.setText("abc");
    }

    private void addControls(View root) {
        spinner_module = root.findViewById(R.id.spinner_module);
        spinner_class = root.findViewById(R.id.spinner_class);
        spinner_trainer = root.findViewById(R.id.spinner_trainer);
        btn_Save = root.findViewById(R.id.btn_Save);
        btn_Back = root.findViewById(R.id.btn_Back);

        //
        textView2 = root.findViewById(R.id.textView2);
    }
}