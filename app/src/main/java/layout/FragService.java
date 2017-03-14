package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.joelnetodev.aprendendoandroid.R;
import com.joelnetodev.aprendendoandroid.Service.ServiceAprendendoAndroid;

public class FragService extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        return inflater.inflate(R.layout.frag_service, container, false);
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
        final Button buttonStart = (Button) getView().findViewById(R.id.btnServ1);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), ServiceAprendendoAndroid.class);
                getContext().startService(intent);
            }
        });


        final Button buttonStop = (Button) getView().findViewById(R.id.btnServ2);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), ServiceAprendendoAndroid.class);
                getContext().stopService(intent);
            }
        });
    }
}
