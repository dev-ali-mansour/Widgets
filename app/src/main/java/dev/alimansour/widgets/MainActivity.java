package dev.alimansour.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private TextView messageTextView;
    private Button button;
    private ImageButton playButton;
    private CheckBox checkBox;
    private SwitchCompat switchCompat;
    private ToggleButton toggleButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = findViewById(R.id.messageTextView);
        button = findViewById(R.id.button);
        playButton = findViewById(R.id.playButton);
        checkBox = findViewById(R.id.checkbox);
        switchCompat = findViewById(R.id.mySwitch);
        toggleButton = findViewById(R.id.toggleButton);
        radioGroup = findViewById(R.id.radioGroup);

        button.setOnClickListener(this);
        playButton.setOnClickListener(this);
        checkBox.setOnClickListener(this);
        toggleButton.setOnClickListener(this);

        switchCompat.setOnCheckedChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.equals(button)) {
            messageTextView.setText("Button clicked");
        } else if (v.equals(playButton)) messageTextView.setText("Play music");
        else if (v.equals(checkBox)) {
            if (checkBox.isChecked()) messageTextView.setText("CheckBox checked");
            else messageTextView.setText("CheckBox not checked");
        } else if (v.equals(toggleButton)) {
            messageTextView.setText("Toggle Button changed: " + toggleButton.getText());
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.equals(switchCompat)) {
            if (isChecked) messageTextView.setText("Switch is on");
            else messageTextView.setText("Switch is off");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group.equals(radioGroup)) {
            switch (checkedId) {
                case R.id.maleRadioButton:
                    messageTextView.setText("User is male");
                    break;
                case R.id.femaleRadioButton:
                    messageTextView.setText("User is female");
                    break;
                case R.id.preferRadioButton:
                    messageTextView.setText("User prefers to don't be identified");
                    break;
                default:
                    messageTextView.setText("Un defined gender!");
                    break;
            }
        }
    }
}