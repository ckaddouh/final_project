private void doTime() {
    Timeline time = new TimeLine();
    time.setCycleCount(Timeline.INDEFINITE);
    if (time != null) {
        time.stop();
    }

    KeyFrame frame = new KeyFrame(Duration.second(1), new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
        seconds--;
        DrawingScreen.timerLabel.setText(seconds.toString() + " seconds remaining");
        if (seconds <= 0){
            time.stop();
        }
    }
    });

    time.getKeyFrames().add(frame);
    time.playFromStart();
}