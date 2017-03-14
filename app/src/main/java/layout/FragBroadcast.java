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
import com.joelnetodev.aprendendoandroid.Util.UtilClass;

public class FragBroadcast extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        return inflater.inflate(R.layout.frag_broadcast, container, false);
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
        Button buttonStart = (Button) getView().findViewById(R.id.btnBroadcast1);
        buttonStart.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(UtilClass.getBroadcastName());
                getContext().sendBroadcast(intent);
            }
        });
    }
}
