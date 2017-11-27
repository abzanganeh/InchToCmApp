package edu.pcc.alizanganeh.feetintocmapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OutputFragment extends Fragment {

    private String mResult;

    public OutputFragment() {
        // Required empty public constructor
    }

    public void setValues (String result) {
        mResult = result;
        setOutput();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_output, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        setOutput();

    }
    private void setOutput() {

        View view = getView();

        if (view == null) {
            return;
        }
        String result = mResult;
        TextView resultTextView = (TextView) view.findViewById(R.id.result);
        resultTextView.setText(mResult);
    }

}
