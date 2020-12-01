package org.gof.behavioral.patterns7.state.player.context;

import org.gof.behavioral.patterns7.state.player.state.IPodState;

import java.util.ArrayList;
import java.util.List;

public class IPod {

    private IPodState state;

    private int musicIndex;

    private List<String> musics = new ArrayList();

    private IPod() {
        musics.add("music1......");
        musics.add("music2......");
        musics.add("music3......");
        musics.add("music4......");
        musics.add("music5......");
    }

    public List<String> getMusics() {
        return musics;
    }

    public int getMusicIndex() {
        return musicIndex;
    }

    public void setMusicIndex(int musicIndex) {
        this.musicIndex = musicIndex;
    }

    public void setState(IPodState state) {
        this.state = state;
    }

    public void change() {
        state.change(this);
    }
}
