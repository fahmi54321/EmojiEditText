package com.android.a38emojiedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView;

public class MainActivity extends AppCompatActivity {

    View rootView;
    CheckBox checkBox;
    EmojiconTextView emojiconTextView;
    EmojiconEditText emojiconEditText;
    ImageView emojiButton,submitButton;
    EmojIconActions emojIconActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = (RelativeLayout) findViewById(R.id.root);
        emojiButton = (ImageView) findViewById(R.id.emoji_button);
        submitButton = (ImageView) findViewById(R.id.submitButton);
        emojiconTextView = (EmojiconTextView) findViewById(R.id.txtContent);
        emojiconEditText = (EmojiconEditText) findViewById(R.id.emoji_edut_text);
        checkBox = (CheckBox) findViewById(R.id.ckb_Default);
        emojIconActions = new EmojIconActions(getApplicationContext(),rootView,emojiButton,emojiconEditText);
        emojIconActions.ShowEmojicon();
        checkBox.setOnCheckedChangeListener(((compoundButton, b) -> {
            emojIconActions.setUseSystemEmoji(b);
            emojiconTextView.setUseSystemDefault(b);
        }));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = emojiconEditText.getText().toString();
                emojiconTextView.setText(message);
            }
        });

    }
}