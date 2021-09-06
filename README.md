# hebrew

Aplikacja jest rozwijana dwutorowo
1. w trybie "normalnym"
2. w trybie na potrzeby deploya na heroku


1. Front uruchamianie "ng serve" z lokalizacji
   D:\02_IT\..............\Front\
2. Backend: Wilenska2021backendApplication przez Springa


--------- deploy na Heroku -------------

Dwa branche sa zdeplojowane na Heroku
- backend_for_heroku -> hebrewbackend
- front_for_heroku -> fronthebrew

z uwagi na to ze na Heroku jest master

1.bedac na branchu front/backend należy w oparciu o ten branch stworzyc brancza *master*
2.nastepnie bedac m module front/backend wykonac w terminalu *git push heroku master*
3. wrocic na pierwotny branch i wymazac *master* 
   ( ta operacja jest spowodowana tym ze na Heroku jest branch Master - teoretycznie mozna to zmienić )

url aplikacji na heroku: https://fronthebrew.herokuapp.com/

--------- sprawdzanie zdalnych uruchominych repozytoriów -------------
git remote -v

np.
D:\02_IT\01_Aplication\01_Hebrew\hebrew\Front>git remote -v
heroku  https://git.heroku.com/fronthebrew.git (fetch)
heroku  https://git.heroku.com/fronthebrew.git (push)
origin  https://github.com/RomanBulinski/hebrewFront.git (fetch)
origin  https://github.com/RomanBulinski/hebrewFront.git (push)

----------------------------------------------------------------------

DODANIE DO APLIKACJI MIKROMETER, PROMETHEUS, GRAFANA wg. Darka Mydlarza
https://www.youtube.com/watch?v=W6HKXjUBYOs&t=741s

------------micrometer----------------
dopisany do applikacji w pom

------------prometheus---------------*
http://localhost:8080/actuator/prometheus  -> powinien chodzic Prometheus
w pliku docker-compose.yml postawilem serwerek z prometheuse
http://localhost:9000/ -> consola prometheusa

------------grafana------------------*
https://grafana.com/grafana/dashboards/4701 -> dashbordy
http://localhost:3000/

* grafana i prometheus uruchamiane sa na dockerkach skonfigurowanych w pliku docker-compose.yml
