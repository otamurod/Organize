//
//  Koin.swift
//  iosApp
//
//  Created by Otamurod Safarov on 25/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Shared

final class Koin {
    private var core: Koin_coreKoin?

    static let instance = Koin()

    static func start() {
        if instance.core == nil {
            let app = KoinIOS.shared.initialize(
                userDefaults: UserDefaults.standard
            )
            instance.core = app.koin
        }
        if instance.core == nil {
            Logger.companion.log(message: "Cannot initialize Koin.", tag: "Koin", level: LogLevel.error)

            fatalError("Cannot initialize Koin.")
        }
    }

    private init() {}

    func get<T: AnyObject>() -> T {
        guard let core = core else {
            fatalError("You should call ´start()´ before using \(#function)")
        }

        guard let result = core.get(objCClass: T.self) as? T else {
            fatalError("Koin cannot provide an instance of type: \(T.self)")
        }

        return result
    }
}
