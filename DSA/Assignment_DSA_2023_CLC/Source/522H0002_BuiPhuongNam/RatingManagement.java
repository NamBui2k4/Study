import java.util.*;
import java.io.*;

class compareMovie implements Comparator<Movie> {
        @Override
        public int compare(Movie A, Movie B) {
            Queue<Character> a = new LinkedList<Character>();
            for(Character i : A.getName().toCharArray()){
                if(Character.isLetter(i)){
                    a.add(i);
                }
            }
            Queue<Character> b = new LinkedList<Character>();
            for(Character i : B.getName().toCharArray()){
                if(Character.isLetter(i)){
                    b.add(i);
                }
            }
            boolean bigger = true;

            while(!a.isEmpty() && !b.isEmpty()){
                char ch1 = a.poll();
                char ch2 = b.poll();
                if (ch1 == ch2)
                    continue;
                if(ch1 > ch2){
                    break;
                }
                if (ch1 < ch2){
                    bigger = false;
                    break;
                }   
            }
            if (bigger){
                return 1;
            }
            return -1;
            
        }
    }

public class RatingManagement {
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    public RatingManagement(String moviePath, String ratingPath, String userPath) {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) {
        ArrayList<Rating> result = new ArrayList<Rating>();
        try{
            File f = new File(ratingPath);
            Scanner file_scaned = new Scanner(f); 
            if (file_scaned.hasNextLine()) {
                file_scaned.nextLine();
            }
            while(file_scaned.hasNextLine()){
                String line = file_scaned.nextLine();
                String data[] = line.split(",");
                int userId = Integer.parseInt(data[0]);
                int movieID = Integer.parseInt(data[1]);
                int startRating = Integer.parseInt(data[2]); 
                long timeStamp = Long.parseLong(data[3]);
                Rating a = new Rating(userId, movieID, startRating, timeStamp);
                result.add(a);
            }
            file_scaned.close(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        /* code here */
        return result; /* change here */
    }

    private ArrayList<Movie> loadMovies(String moviePath) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        try{
            File f = new File(moviePath);
            Scanner file_scaned = new Scanner(f); 
            
            if (file_scaned.hasNextLine()) {
                file_scaned.nextLine();
            }
            while(file_scaned.hasNextLine()){
                String line = file_scaned.nextLine();
                String data[] = line.split(",");
                int MovieID = Integer.parseInt(data[0]);
                String Title = data[1];
                ArrayList<String> list_genres = new ArrayList<String>();
                String Genres[] = data[2].split("-");
                for(String genre : Genres){
                    list_genres.add(genre);
                }
                Movie movie = new Movie(MovieID, Title, list_genres);
                result.add(movie);
            }
            file_scaned.close(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        /* code here */
        return result; 
    }

    private ArrayList<User> loadUsers(String userPath) {
        ArrayList<User> result = new ArrayList<User>();
        try{
            File f = new File(userPath);
            Scanner file_scaned = new Scanner(f); 
            if (file_scaned.hasNextLine()) {
                file_scaned.nextLine();
            }
            while(file_scaned.hasNextLine()){
                String line = file_scaned.nextLine();
                String data[] = line.split(",");
                int UserID = Integer.parseInt(data[0]);
                String Gender = data[1];
                int Age = Integer.parseInt(data[2]);
                String Occupation = data[3];
                String Zip_code = data[4];
                User user = new User(UserID, Gender, Age, Occupation, Zip_code);
                result.add(user);
            }
            file_scaned.close(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;    
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Rating> getRating() {
        return ratings;
    }

    
    public static ArrayList<Movie> sortMovies(ArrayList<Movie> a) {
        compareMovie cmp = new compareMovie();
        for(int i = 0 ; i < a.size() - 1 ; i++) {
            for(int j = i + 1 ; j < a.size() ; j++) {
                if (cmp.compare(a.get(i), a.get(j)) > 0) {
                    Movie temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
        return a;
    }
    // @Requirement 2
    public ArrayList<Movie> findMoviesByNameAndMatchRating(int userId, int rating) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        for(Rating r : ratings){
            if (r.getUserId() == userId && r.getRatingStar() >= rating){
                int movieId = r.getMoveId();
                for(Movie movie : movies){
                    if(movieId == movie.getId()){
                        result.add(movie);
                    }
                }   
            }
        }      
        return sortMovies(result);
    }

    public static ArrayList<User> sortUsers(ArrayList<User> a) {
        for(int i = 0 ; i < a.size() - 1 ; i++) {
            for(int j = i + 1 ; j < a.size() ; j++) {
                int x = a.get(i).getId();
                int y = a.get(j).getId();
                if ( x > y) {
                    User temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
        return a;
    }
    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int moveId) {
        ArrayList<User> result = new ArrayList<User>();
        int rate = 0 ;
        for(Rating r : ratings){
            if(r.getMoveId() == moveId && r.getUserId() == userId){
                rate =  r.getRatingStar();
                break;
            }
        }
        ArrayList<Rating> temp = new ArrayList<>();
        for(Rating r : ratings){
            if(r.getMoveId() == moveId && r.getRatingStar() == rate && r.getUserId() != userId){
                temp.add(r);
            }
        }
        for(User u : users) {
            for(Rating r : temp){
                if(u.getId() ==  r.getUserId())
                    result.add(u);
            }
        }
        
        return sortUsers(result); /* change here */
    }

    // Requirement 4
    public ArrayList<String> findMoviesNameHavingSameReputation() {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Rating> RatingMorethan3 = new ArrayList<Rating>();
        for(Rating r: ratings){
            if(r.getRatingStar() > 3){
                RatingMorethan3.add(r);
            }
        }
        HashMap<Integer, Integer> mapMoreThan3 = new HashMap<Integer, Integer>();
        ArrayList<Integer> ListIdmoreThan3 = new ArrayList<Integer>();
        
        for(int i = 0; i < RatingMorethan3.size(); i++){
            Integer idMovie = RatingMorethan3.get(i).getMoveId();
            if(mapMoreThan3.containsKey(idMovie)){
                mapMoreThan3.put(idMovie, mapMoreThan3.get(idMovie) + 1);
            }else{
                mapMoreThan3.put(idMovie, 1);
            }
            if(mapMoreThan3.get(idMovie) >=2){
                ListIdmoreThan3.add(idMovie);
            }
        }

        for(Movie m : movies){
            int id = m.getId();
            if(ListIdmoreThan3.contains(id)){
                result.add(m.getName());
            }
        }
        
        Collections.sort(result); /* change here */
        return result;
    }
   
    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) {
        ArrayList<Integer> IdUserSameOccGen = new ArrayList<Integer>();

        for(User u : users){
           if(u.getOccupation().equals(occupation) && u.getGender().equals(gender)){ 
                IdUserSameOccGen.add(u.getId());
            }
        }
        
        ArrayList<Integer> IdMovieRated = new ArrayList<Integer>();
        for(Rating r : ratings){
            int UserRate = r.getRatingStar();
            int UserId   = r.getUserId();
            int MovieID  = r.getMoveId();
            
           if(UserRate == rating && IdUserSameOccGen.contains(UserId)){
                IdMovieRated.add(MovieID);
           }
        }
        
        ArrayList<String> AllMovieNames = new ArrayList<String>();
        for(Movie m : movies){
            if(IdMovieRated.contains(m.getId())){
                AllMovieNames.add(m.getName());
            }

        }
        Collections.sort(AllMovieNames);
        ArrayList<String> result = new ArrayList<>(AllMovieNames.subList(0, k));
        return result; /* change here */
    }

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        ArrayList<Integer> IdUserSameOccGen = new ArrayList<Integer>();

        for(User u : users){
           if(u.getOccupation().equals(occupation)){ 
                IdUserSameOccGen.add(u.getId());
            }
        }
        
        ArrayList<Integer> IdMovieRated = new ArrayList<Integer>();
        for(Rating r : ratings){
            int UserRate = r.getRatingStar();
            int UserId   = r.getUserId();
            int MovieID  = r.getMoveId();
            
           if(UserRate < rating && IdUserSameOccGen.contains(UserId)){
                IdMovieRated.add(MovieID);
           }
        }
        
        ArrayList<String> AllMovieNames = new ArrayList<String>();
        for(Movie m : movies){
            if(IdMovieRated.contains(m.getId())){
                AllMovieNames.add(m.getName());
            }

        }
        Collections.sort(AllMovieNames);
        ArrayList<String> result = new ArrayList<>(AllMovieNames.subList(0, k));
        return result;
    }

    public Rating findLatestRating(int userId,int rating) {
        Rating latestRating = null;
    
        for (Rating r : ratings) {
            if (r.getUserId() == userId) {
                if (latestRating == null || r.gettimeStamp() > latestRating.gettimeStamp() && r.getRatingStar() >= rating) {
                    latestRating = r;
                }
            }
        }
    
        return latestRating;
    }
    public User findtUserById(int userId) {
        for(User u : users){
            if(u.getId() == userId)
                return u;
        }
        return null;
    }
    public Movie getMoveByIds(int idMovie) {
        for(Movie m : movies){
            if(m.getId() == idMovie)
                return m;
        }
        return null;
    }
    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        // find latest rating movie
        Rating lastRating = findLatestRating(userId,rating);
        // find genres of the movie rated
        ArrayList<String> GenreOfMovie = new ArrayList<>();
        for(Movie m : movies){
            if(m.getId() == lastRating.getMoveId()){
                GenreOfMovie = m.getGenres();
                break;
            };
        }
        // find user by userId
        User user = findtUserById(userId);
        // get user's gender
        String userGender = user.getGender();

        // find rating of people who have the same gender of user 
        // the people's rating star must be >= rating 
        ArrayList<Rating> ratingSameGender = new ArrayList<>();
        for(Rating r : ratings){
            User otherUsers = findtUserById(r.getUserId());
            if(otherUsers.getId() != userId && otherUsers.getGender().equals(userGender) && r.getRatingStar() >= rating)
                ratingSameGender.add(r);
        }

        // from people's rating, find their movies 
        ArrayList<Movie> movieSameGender = new ArrayList<Movie>();
        for(Rating r : ratingSameGender){
            movieSameGender.add(getMoveByIds(r.getMoveId()));
        }
        // get movies names if they conclude at least one genre of user's movies
        HashSet<String> AllMovieNames = new HashSet<String>();
        for(Movie m : movieSameGender){
           if(contains(GenreOfMovie, m.getGenres())){
                AllMovieNames.add(m.getName());
           }
                
        }
        ArrayList<String> result = new ArrayList<>(AllMovieNames);
        Collections.sort(result);
        
        return new ArrayList<>(result.subList(0,  k));
    }

    public static boolean contains(ArrayList<String> a, ArrayList<String> b){
        for(String i : b){
            if(a.contains(i))
                return true;
            else
                continue;
        }
        return false;
    }
    
}

