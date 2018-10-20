package uk.co.globalbiewsystems.spotthatfire;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class FireShow extends Fragment {

    private Button submit;
    private RadioGroup smokeGroup;
    private RadioGroup fireGroup;
    private RadioGroup severityGroup;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fire_show, parent, false);

        submit = view.findViewById(R.id.sendButton);
        smokeGroup = view.findViewById(R.id.SmokeGroup);
        fireGroup = view.findViewById(R.id.FireGroup);
        severityGroup = view.findViewById(R.id.SeverityGroup);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int smokeResult = smokeGroup.getCheckedRadioButtonId();
                View smokeResultView = smokeGroup.findViewById(smokeResult);
                int SmokeIndex = smokeGroup.indexOfChild(smokeResultView);
                RadioButton actualSmoke = (RadioButton) smokeGroup.getChildAt(SmokeIndex);

                int fireResult = fireGroup.getCheckedRadioButtonId();
                View fireResultView = fireGroup.findViewById(fireResult);
                int fireIndex = fireGroup.indexOfChild(fireResultView);
                RadioButton actualFire = (RadioButton) fireGroup.getChildAt(fireIndex);

                int severityResult = severityGroup.getCheckedRadioButtonId();
                View severityResultView = severityGroup.findViewById(severityResult);
                int severityIndex = severityGroup.indexOfChild(severityResultView);
                RadioButton actualSeverity = (RadioButton) severityGroup.getChildAt(severityIndex);



            }
        });
        return view;
    }
}
