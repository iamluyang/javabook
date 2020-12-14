package org.gof.behavioral.patterns7.state2.player.context;

import org.gof.behavioral.patterns7.state2.player.state.*;

import java.util.ArrayList;
import java.util.List;

public class IPod {

    private IPodState state;

    private int musicIndex;

    private List<String> musics = new ArrayList();

    public IPod() {
        musics.add("music1......");
        musics.add("music2......");
        musics.add("music3......");
        musics.add("music4......");
        musics.add("music5......");
        this.setState(new On());
    }

    public List<String> getMusics() {
        return musics;
    }

    public int getMusicIndex() {
        return musicIndex;
    }

    public void setMusicIndex(int musicIndex) {
        if(musicIndex<0) {
            this.musicIndex = 0;
            return;
        }else if(musicIndex >= musics.size()) {
            this.musicIndex = 0;
            return;
        }
        this.musicIndex = musicIndex;
    }

    public IPodState getState() {
        return state;
    }

    public void setState(IPodState state) {
        this.state = state;
    }

    public void change() {
        this.state.change(this);
    }

    public void on() {
        IPodState on = new On();
        on.change(this);
    }

    public void off() {
        IPodState off = new Off();
        off.change(this);
    }

    public void pause() {
        IPodState pause = new Pause();
        pause.change(this);
    }

    public void next() {
        IPodState next = new Next();
        next.change(this);
    }

    public void prev() {
        IPodState prev = new Prev();
        prev.change(this);
    }
}
