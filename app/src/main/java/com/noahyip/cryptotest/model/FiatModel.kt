package com.noahyip.cryptotest.model

class FiatModel(
    id: String,
    name: String,
    symbol: String,
    code: String
) : CurrencyInfo(id, name, symbol)