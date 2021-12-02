(ns elyses-destructured-enchantments)

(def deck [5 9 7 1 8])

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[a & others] deck]
    a)
)

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[a b & others] deck]
    b)
)


(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[a b & others] deck]
    (vec (remove nil? (flatten [b a others]))))
)


(defn discard-top-card
  "Returns a vector containing the first card and
   a vector of the remaining cards in the deck."
  [deck]
  (let [[a & others] deck]
    [a  others])
)


(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[a & others] deck]
    (vec (flatten (remove nil? [a face-cards others]))))
)



