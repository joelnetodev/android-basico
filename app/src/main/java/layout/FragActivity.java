package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.joelnetodev.aprendendoandroid.Activity.Activity1ForActivity;
import com.joelnetodev.aprendendoandroid.R;

public class FragActivity extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        return inflater.inflate(R.layout.frag_activity, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        //getActivity().setTitle("Introdução");

        buttonClick();
    }

    private void buttonClick()
    {
        final Button button = (Button) getView().findViewById(R.id.btnActiv1);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = (EditText) getView().findViewById(R.id.editText1);
                String valorDigitado = editText.getText().toString();

                Intent intent = new Intent(getActivity(), Activity1ForActivity.class);
                intent.putExtra("digitado",valorDigitado);

                startActivity(intent);
            }
        });
    }
}
