happy(yolanda). 
listens2Music(mia). 
listens2Music(yolanda) :- happy(yolanda). 
playsGuitar(mia) :- listens2Music(mia). 
playsGuitar(yolanda) :- listens2Music(yolanda). 

