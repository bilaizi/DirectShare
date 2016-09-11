package com.example.bilaizi.directshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

/**
 * Provides the landing screen of this sample. There is nothing particularly interesting here. All
 * the codes related to the Direct Share feature are in {@link SampleChooserTargetService}.
 */
public class MainActivity extends Activity {

    private EditText mEditBody;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar((Toolbar) findViewById(R.id.toolbar));
        mEditBody = (EditText) findViewById(R.id.body);
        mButton = (Button) findViewById(R.id.share);
        mButton.setOnClickListener(
                view -> {
                    switch (view.getId()) {
                        case R.id.share:
                            share();
                            break;
                    }
                }
        );
    }

    /**
     * Emits a sample share {@link Intent}.
     */
    private void share() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mEditBody.getText().toString());
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));
    }

}