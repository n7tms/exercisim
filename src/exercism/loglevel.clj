(ns log-levels
  (:require [clojure.string :as str]))

(def error "[ERROR]:   Invalid operation  ")
(def warning "[WARNING]:  Disk almost full\r\n")


(defn parse-msg [message]
  (let [[_  level msg]
        (re-matches #"\[(\w+)\]:\s+(.*)" (str/trim message))]
    {:level level
     :msg (str/trim msg)}
  )
)

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (:msg (parse-msg s))
  )


(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (str/lower-case (:level (parse-msg s)))
)

(log-level error)

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")")
  )


