(ns game-of-fifteen.events
    (:require [re-frame.core :as re-frame]
              [game-of-fifteen.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
