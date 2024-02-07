public class Rating{
    private int userId; // src
    private int  moveId; // dest
    private int ratingStar; //
    private long timeStamp; // start
    

    public Rating(int userId, int moveId, int ratingStar, long timeStamp) {
        this.userId = userId;
        this.moveId = moveId;
        this.ratingStar = ratingStar;
        this.timeStamp = timeStamp;
    }   


    @Override
    public String toString() {
        return String.format("(%d, %d, %d, %d)",userId, moveId, ratingStar, timeStamp);
    }


    public int getUserId() {
        return userId;
    }


    public int getMoveId() {
        return moveId;
    }


    public int getRatingStar() {
        return ratingStar;
    }


    public long gettimeStamp() {
        return timeStamp;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public void setMoveId(int moveId) {
        this.moveId = moveId;
    }


    public void setRatingStar(int ratingStar) {
        this.ratingStar = ratingStar;
    }


    public void settimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
