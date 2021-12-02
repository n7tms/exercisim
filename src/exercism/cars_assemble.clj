(ns cars-assemble)

(defn production-rate [speed]
  (cond
    (= speed 0) 0.0
    (<= 1 speed 4) (* speed 221.0)
    (<= 5 speed 8) (* 0.9 (* speed 221.0))
    (= speed 9) (* 0.8 (* speed 221.0))
    :else (* 0.77 (* 10 221.0))))

(production-rate 0)

(defn working-items [speed]
  (int (/ (production-rate speed) 60))
  )

(working-items 6)
