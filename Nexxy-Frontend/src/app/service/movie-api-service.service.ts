import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, forkJoin, map } from 'rxjs';
import { MovieDetails } from '../Entities/moviedetails/MovieDetails';
import { VideoInformation } from '../Entities/videoinformation/VideoInformation';
import { Movie } from '../Entities/movie/Movie';

@Injectable({
  providedIn: 'root',
})
export class MovieApiServiceService {
  constructor(private http: HttpClient) {}

  baseurl = 'https://api.themoviedb.org/3';
  apikey = '08cc33bd5ae3a747598ce2ad84376e66';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };
  //bannerapidata

  bannerApiData(): Observable<any> {
    return this.http.get(
      `${this.baseurl}/trending/all/week?api_key=${this.apikey}`
    );
  }
  getMovies(): Observable<any> {
    console.log("TEST",this.http.get<any>('http://localhost:8080/web/api/movies').toString());
    
    return this.http.get<any>("http://localhost:8080/web/api/movies");
  }

  // trendingmovieapidata
  trendingMovieApiData(): Observable<any> {
    return this.http.get(
      `${this.baseurl}/trending/movie/day?api_key=${this.apikey}`
    );
  }

  searchMovieWithName(data: any): Observable<any> {
    return this.http.get(
      `${this.baseurl}/search/movie?api_key=${this.apikey}&query=${data.movieName}`
    );
  }

  getMovie(data: any): Observable<any> {
    return this.http.get(
      `${this.baseurl}/movie/${data}?api_key=${this.apikey}`
    );
  }

  getMovieVideo(data: any): Observable<any> {
    return this.http.get(
      `${this.baseurl}/movie/${data}/videos?api_key=${this.apikey}`
    );
  }

  getMovieCast(data: any): Observable<any> {
    return this.http.get(
      `${this.baseurl}/movie/${data}/credits?api_key=${this.apikey}`
    );
  }
  createMovie(movie:Movie):Observable<Movie>{
    console.log(movie);
    
    return this.http.post<Movie>("http://localhost:8080/web/api/movie",JSON.stringify(movie));
  }
  getMovieById(id:number):Observable<any>{
    return this.http.get(`http://localhost:8080/web/api/movie/${id}`);
  }
  getMovieDetails(movieId: number): Observable<MovieDetails> {
    return forkJoin({
      movie: this.getMovie(movieId), // Assuming getMovie returns movie details
      cast: this.getMovieCast(movieId).pipe(map((data) => data.cast.slice(0, 10)  || [])),
      movieVideo: this.getMovieVideo(movieId).pipe(
        map((result) => result.results.find((element: VideoInformation) => element.type === 'Trailer'))
      ),
    }).pipe(
      map((data) => ({
        ...data,
      }))
    );
  }
}
function JSONstringify(movie: Movie) {
  throw new Error('Function not implemented.');
}

