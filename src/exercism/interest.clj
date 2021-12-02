(ns interest-is-interesting)

(def tax-free-percentage 2.5)

(defn abs [x] (cond-> x (neg? x) -))

(defn interest-rate
  "calculate the interest rate based on the specified balance"
  [balance]
  (cond
    (< balance 0M) -3.213
    (<= 0M balance 999.99999M) 0.5
    (<= 1000M balance 4999.99999M)  1.621
    :else 2.475
  )
)


(defn annual-balance-update
  "calculate the annual balance update, taking into account the interest rate"
  [balance]
  ;; (if (< balance 0)
  ;;   (bigdec (- balance (* balance (* 0.01 (interest-rate balance)))))
  ;;   (bigdec (+ balance (* balance (* 0.01 (interest-rate balance))))))
  (let [interest (interest-rate balance)
        mul (bigdec (/ interest 100))]
    (+ balance (* (abs balance) mul))))


(defn amount-to-donate
  "calculate how much money to donate to charities"
  [balance tax-free-percentage]
  (int (* 2 (* balance (* 0.01 tax-free-percentage))))
  )


