(ns repro-ssr.ui.root
  (:require
    [fulcro.client.mutations :as m]
    [fulcro.client.data-fetch :as df]
    #?(:cljs [fulcro.client.dom :as dom]
       :clj [fulcro.client.dom-server :as dom])
    [repro-ssr.api.mutations :as api]
    [fulcro.client.primitives :as prim :refer [defsc]]
    [fulcro.i18n :as i18n :refer [tr trf]]))

;; The main UI of your application

(defsc Foo
  [this props]
  (dom/div "foo"))

(def ui-foo (prim/factory Foo))

(defsc Root [this props]
  ;;;;;;;;;;;;
  ;; broken ;;
  ;;;;;;;;;;;;
  (dom/div :.test
    (ui-foo))
  ;;;;;;;;;;;;;
  ;; working ;;
  ;;;;;;;;;;;;;
  #_(dom/div
    {:className "test"}
    (ui-foo)))
