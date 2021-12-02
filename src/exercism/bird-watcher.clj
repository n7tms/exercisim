(ns bird-watcher)

(def last-week '[0 2 5 3 7 8 4]
  )

(def birds-per-day [2 5 0 7 4 1])

(defn today [birds]
  (last birds)
  )

(defn inc-bird [birds]
  (conj (vec (butlast birds)) (inc (last birds)))
  )

(defn day-without-birds? [birds]
  (if  (some zero? birds) true false)
  )

(defn n-days-count [birds n]
  (reduce + (take n birds))
  )

(n-days-count birds-per-day 5)

(defn busy-days [birds]
  (count (filter #(< 4 %) birds))
  )

(busy-days birds-per-day )

(def in [1 0 1 0 1 0 1])

(defn odd-week? [birds]
  (if (and
       (= 1 (nth birds 0) (nth birds 2) (nth birds 4) (nth birds 6))
       (= 0 (nth birds 1) (nth birds 3) (nth birds 5)))
    true
    false))

(odd-week? in)
